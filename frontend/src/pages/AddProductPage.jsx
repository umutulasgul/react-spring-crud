import React from "react";
import ProductForm from "../components/ProductForm";
import { Link } from "react-router-dom";
function AddProductPage() {
  return (
    <>
      <ProductForm></ProductForm>
      <Link to="/">
        <button>Go back</button>
      </Link>
    </>
  );
}

export default AddProductPage;
