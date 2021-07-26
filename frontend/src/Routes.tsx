import React from 'react';
import { Router, Switch, Route, Redirect  } from 'react-router-dom';
import Navbar from './core/components/Navbar';
import history from './core/utils/history';
import Home from 'pages/Home';
import UserRegister from 'pages/User/components/UserRegister';
import User from 'pages/User';
import Auth from 'pages/Auth';

const Routes = () => (
    <Router history={history}>
    <Navbar />
        <Switch>
            <Route path="/" exact>
                <Home />
            </Route>
            <Route path="/users/new">
                <UserRegister />
            </Route>
            <Route path="/users/:userId">
                <User />
            </Route>
            <Redirect from="/auth" to="/auth/login" exact/>
            <Route path="/auth">
                <Auth />
            </Route>
            <Redirect from="/admin" to="/admin/subjects" exact/>
            <Route path="/admin">
                <Admin />
            </Route>
        </Switch>
    </Router>
);

export default Routes;