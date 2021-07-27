import React from 'react';
import AuthImage from 'core/assets/images/img-login.jpeg';
import { Route, Switch } from 'react-router-dom';
import Login from './components/Login';
import './styles.scss';
import UserRegister from 'pages/User/components/UserRegister';

const Auth = () => ( 
    <div className="auth-container">
        <div className="auth-info">
            <h1 className="auth-info-title">
                MapinPedagogics
            </h1>
            <p className="auth-info-subtile">
                Startup de soluções tecnológicas para educação
            </p>
           <img src={AuthImage} alt="logo" className="auth-img" />
        </div>
        <div className="auth-content">
            <Switch>
                <Route path="/auth/login">
                    <Login />
                </Route>
                <Route path="/users/new">
                    <UserRegister />
                </Route>
                <Route path="/auth/recover">
                    <h1>PÁGINA EM CONSTRUÇÃO</h1>
                </Route>
            </Switch>
        </div>
    </div>
);

export default Auth;
