import React from 'react';
import { Link } from 'react-router-dom';

export const Header = () => {

  
  return(
    <div className="navbar is-primary">
      <div className="navbar-brand">
        <Link to='/' className='navbar-item'>
          <img src='logo.png' alt='logo' />
        </Link>
      </div>
    </div>

  )
};
