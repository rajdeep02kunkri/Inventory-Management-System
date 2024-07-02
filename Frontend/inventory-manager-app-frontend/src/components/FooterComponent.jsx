import React from 'react';

const FooterComponent = () => {
  return (
    <footer className="footer">
      <div className="container">
        <div className="row">
          <div className="col-md-4">
            <h5>About Us</h5>
            <p> Welcome to 'RK & Company', where innovation meets excellence. 
              We are a team of dedicated professionals committed to delivering top-notch solutions tailored to meet the unique needs of our clients. At 'RK & Company', we believe in pushing boundaries and exploring new horizons. With a focus on creativity and cutting-edge technology, we strive to revolutionize industries and make a lasting impact on the world. Our journey began with a simple idea: to provide innovative solutions that empower businesses to thrive in the digital age. 
            </p>
          </div>
          <div className="col-md-4">
            <h5>Quick Links</h5>
            <ul>
              <li><a href="#">Home</a></li>
              <li><a href="#">About</a></li>
              <li><a href="#">Services</a></li>
              <li><a href="#">Contact</a></li>
            </ul>
          </div>
          <div className="col-md-4">
            <h5>Contact Us</h5>
            <p>456, Kamla Nagar,New Delhi,India.</p>
            <p>Email: rkandcompany@gmail.com</p>
            <p>Phone: +123456789</p>
          </div>
        </div>
        <hr />
        <div className="row">
          <div className="col-md-12 text-center">
            <p>&copy; {new Date().getFullYear()} RK & Company. All rights reserved.</p>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default FooterComponent;
