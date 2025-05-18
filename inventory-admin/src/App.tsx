// import './App.css'
import {useEffect, useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";

function App() {
    const[data,setData] = useState([]);
    const navigate = useNavigate();
    useEffect(()=>{
      axios.get("https://fakestoreapi.com/products")
          .then(response=>{
              setData(response.data)
          });
      },[]);
  return (
      <>
          <div className="p-3 grid grid-cols-4 gap-4 font-sans">
          {data.map((product,index)=>(
              <div
                  key={product.id}
                  className="border flex flex-col justify-center items-center p-4 cursor-pointer hover:shadow-md transition-shadow"
                  onClick={() => { navigate(`/product/${product.id}`,{ replace: true }); }}
              >
                  <img src={product.image} height="200px" width="100px"/>
                  <h3 className="text-black font-medium">{product.title}</h3>
                  <div>${product.price}</div>
              </div>
          ))}
          </div>
      </>

  )
}

export default App
