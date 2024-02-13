import { useState, useEffect } from "react";
import axios from "axios";

function useProducts() {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    setLoading(true);
    setError(null);

    axios
      .get("http://localhost:8080/api/v1/products")
      .then((response) => setProducts(response.data.data))
      .catch((error) => setError(error.message))
      .finally(() => setLoading(false));
  }, []);

  return { products, loading, error };
}

export default useProducts;
