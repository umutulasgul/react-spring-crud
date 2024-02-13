import React from "react";
import ProductTable from "../components/ProductTable";
import { Link } from "react-router-dom";
function HomePage() {
  return (
    <>
      <ProductTable />
      <Link to="/add">
        <button>Add Product</button>
      </Link>
    </>
  );
}

export default HomePage;
