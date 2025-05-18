import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import ProductPage from "@/ProductPage";
import App from "@/App";
const AppRouter = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<App />} />
                <Route path="/product/:id" element={<ProductPage />} />
            </Routes>
        </Router>
    );
}
export default AppRouter;
