/**
 *
 * App.js
 *
 * This component is the skeleton around the actual pages, and should only
 * contain code that should be seen on all pages. (e.g. navigation bar)
 *
 */

import React from 'react';
import { Switch, Route } from 'react-router-dom';

import HomePage from 'containers/HomePage/Loadable';
import NotFoundPage from 'containers/NotFoundPage/Loadable';

import GlobalStyle from '../../global-styles';
import 'bootstrap/dist/css/bootstrap.min.css';
import LoginPage from '../LoginPage';
import SignUpPage from '../SignUpPage';
import CulturalPlacePage from '../CulturalPlacePage';
import CulturalPlacesListPage from '../CulturalPlacesListPage';

export default function App() {
  return (
    <div>
      <Switch>
        <Route exact path="/" component={HomePage} />
        <Route exact path="/login" component={LoginPage} />
        <Route exact path="/sign-up" component={SignUpPage} />
        <Route exact path="/cultural-place/:id"  strict
        sensitive
        render={({ match }) => {
          return match ? <CulturalPlacePage match={match} /> : <NotFound />
        }}/>
        <Route
          exact
          path="/cultural-place-list"
          component={CulturalPlacesListPage}
        />
        <Route component={NotFoundPage} />
      </Switch>

      <GlobalStyle />
    </div>
  );
}