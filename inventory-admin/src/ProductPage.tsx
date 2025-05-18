import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";

const ProductPage = () => {
    const { id } = useParams();
    const [product, setProduct] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        console.log("Product ID:", id);
        // Fetch product data using the id
        axios.get(`https://fakestoreapi.com/products/${id}`)
            .then(response => {
                setProduct(response.data);
                setLoading(false);
            })
            .catch(error => {
                console.error("Error fetching product:", error);
                setLoading(false);
            });
        }, []);

    if (loading) {
        return <div>Loading product...</div>;
    }

    if (!product) {
        return <div>Product not found</div>;
    }

    return (
        <div className="grid grid-cols-2 gap-5 p-4">
            <div className="flex justify-center items-center">
                <img
                    src={product.image}
                    alt={product.title}
                    className="max-h-80 object-contain"
                />
            </div>
            <div className="border p-4">
                <h1 className="text-2xl font-bold mb-2">{product.title}</h1>
                <p className="text-xl font-semibold mb-2">${product.price}</p>
                <div className="mb-4">
                    <span className="inline-block bg-gray-200 px-2 py-1 rounded">
                        {product.category}
                    </span>
                </div>
                <p className="mb-4">{product.description}</p>
                <div className="mb-2">
                    <span className="font-semibold">Rating:</span> {product.rating?.rate} ({product.rating?.count} reviews)
                </div>
                <button className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">
                    Add to Cart
                </button>
            </div>
        </div>
    );
};

export default ProductPage;
