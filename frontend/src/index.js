import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';


//--------------------------------------------------------------------------------

ReactDOM.render(<App/>, document.getElementById('root'));

//------------------------------------------------------------------------------
//   <ul>
//     <li>Apples</li>
//     <li>Bananas</li>
//     <li>Cherries</li>
//   </ul>
// );
// const myelement = (
//   <div className="para">
//     <p>I am a paragraph.</p>
//     <p>I am a paragraph too.</p>
//   </div>
//   <>
//   <p>I am a paragraph.</p>
//   <p>I am a paragraph too.</p>
// </>
// );
// const myelement = <input type="text" />;
// const x = 2;
// const myelement = <h1>{x < 10 ? "X is Less than 10" : "X is Greater than 10"}</h1>;
// ReactDOM.render(myelement, document.getElementById('John'));
//------------------------------------------------------------------------------

// const myheader = <h1>React is {5 + 5} times better with JSX</h1>;
// ReactDOM.render(myheader, document.getElementById('sandy'));
//------------------------------------------------------------------------------

// const myelement2 = <h1 className="myclass">Hello World</h1>;
// ReactDOM.render(myelement2, document.getElementById('root'));
//------------------------------------------------------------------------------
// ReactDOM.render(
//   <React.StrictMode>
//     <MyApp />
//   </React.StrictMode>,
//   document.getElementById('mydiv')
// );
//------------------------------------------------------------------------------
// ReactDOM.render(
//   <React.StrictMode>
//     <App />
//   </React.StrictMode>,
//   document.getElementById('root')
// );
//------------------------------------------------------------------------------

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
