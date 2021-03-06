import React, { useEffect, useState } from 'react';
import { getAccessTokenDecoded, logout, isAllowebByRole, getSessionData } from 'core/utils/auth';
import { Link, NavLink, useLocation } from 'react-router-dom';
import menu from 'core/assets/images/menu-icon.svg';
import logo from 'core/assets/images/navbar-logo.jpg';
import './styles.scss';

const Navbar = () => {
    const [drawerActive, setDrawerActive] = useState(false);
    const [currentUser, setCurrentUser] = useState('');
    const [currentUserId, setCurrentUserId] = useState<number>();
    const location = useLocation();

    const handleLogout = (event: React.MouseEvent<HTMLAnchorElement, MouseEvent>) => {
        event.preventDefault();
        logout(); 
    }

    useEffect(() => {
        const currentUserData = getAccessTokenDecoded();
        setCurrentUser(currentUserData.user_name);
    }, [location]);

    useEffect(() => {
        const currentUserIdData = getSessionData();
        setCurrentUserId(currentUserIdData.userId);
    }, [location]);
    
    return (
        <nav className="bg-primary navbar-main">
  
                <Link to="/" className="navbar-logo-text">
                    <img 
                    src={logo} 
                    alt="Foto"
                    className="navbar-logo" />
                    <h4>MapinPedagogics</h4>
                </Link>
                <button className="navbar-mobile-btn" type="button" onClick={() => setDrawerActive(!drawerActive)}>
                    <img src={menu} alt="Mobile Menu" />
                </button>

                <div className={ drawerActive ? "navbar-mobile-container" : "navbar-menu-container" }> 
                <ul className="navbar-main-menu">
                    <li>
                    <NavLink onClick={() => setDrawerActive(false)} className="navbar-link" to="/" activeClassName="active" exact>HOME</NavLink>
                    </li>
                    <li>
                    <NavLink onClick={() => setDrawerActive(false)} className="navbar-link" to={`/users/${currentUserId}`} activeClassName="active" exact>DASHBOARD</NavLink>
                    </li>

                    {isAllowebByRole(['ROLE_INSTRUCTOR']) && (
                        <li>
                        <NavLink onClick={() => setDrawerActive(false)} className="navbar-link" to="/report" activeClassName="active" exact>PROFESSOR</NavLink>
                    </li>
                    )}
                    
                    {isAllowebByRole(['ROLE_ADMIN']) && (
                        <li>
                        <NavLink onClick={() => setDrawerActive(false)} className="navbar-link" to="/admin" activeClassName="active" exact>ADMIN</NavLink>
                    </li>
                    )}
                    
                    {drawerActive && ( 
                            <li>
                                {currentUser && (
                                    <a 
                                    href="#logout" 
                                    className="nav-link active d-inline" 
                                    onClick={(e) => {
                                        setDrawerActive(false);
                                        handleLogout(e);
                                    }} >
                                        {`LOGOUT - ${currentUser}`}
                                    </a>
                                )}
                            </li>
                    )}

                    {drawerActive && (
                            <>
                                {!currentUser && (
                                    <li>
                                        <Link onClick={() => setDrawerActive(false)} to="/auth/login" className="navbar-link active">LOGIN</Link>
                                    </li>        
                                )}
                            </>
                        )}
                </ul>
            </div> 
            <div className="user-info-dnone text-right">
               { currentUser && (
                   <>
                    <a href="logout" className="navbar-link active d-inline ml-3" onClick={(e) => {
                        setDrawerActive(false);
                        handleLogout(e);
                    }}>
                        LOGOUT
                    </a>
                    <div>  
                        <h6 className="nav-link-email">{currentUser}</h6>
                    </div>                   
                   </>
               )}
                { !currentUser && (
                    <Link onClick={() => setDrawerActive(false)} className="navbar-link active" to="/auth/login">
                    LOGIN
                    </Link>
                )}
            </div>
        </nav>
    )
};

export default Navbar;