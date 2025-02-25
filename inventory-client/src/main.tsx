import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import {BrowserRouter} from "react-router-dom";
import AppRouter from "@/AppRouter";

createRoot(document.getElementById('root')!).render(
  <StrictMode>
      <AppRouter />
  </StrictMode>,
)
