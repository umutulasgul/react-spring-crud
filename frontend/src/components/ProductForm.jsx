import React, { useState } from "react";
import axios from "axios";

const ProductForm = () => {
  const [formData, setFormData] = useState({
    name: "",
    category: "",
    brand: "",
    price: "",
    description: "",
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await saveFormData(formData);
    console.log(formData);
  };

  const saveFormData = async (data) => {
    try {
      const response = await axios.post(
        "http://localhost:8080/api/v1/products",
        data
      );
      console.log(response);
    } catch (error) {
      console.log(error);
    }
  };

  const renderInput = (name, placeholder) => (
    <input
      name={name}
      type="text"
      className="form-control"
      placeholder={placeholder}
      value={formData[name]}
      onChange={handleInputChange}
    />
  );

  return (
    <form onSubmit={handleSubmit}>
      <div className="row mb-3">
        <div className="col-sm-10">{renderInput("name", "name")}</div>
      </div>
      <div className="row mb-3">
        <div className="col-sm-10">{renderInput("category", "category")}</div>
      </div>
      <div className="row mb-3">
        <div className="col-sm-10">{renderInput("brand", "brand")}</div>
      </div>
      <div className="row mb-3">
        <div className="col-sm-10">{renderInput("price", "price")}</div>
      </div>
      <div className="row mb-3">
        <div className="col-sm-10">
          {renderInput("description", "description")}
        </div>
      </div>
      <div className="row mb-3">
        <div className="col-sm-10 offset-sm-2"></div>
      </div>
      <button type="submit">Add Product</button>
    </form>
  );
};

export default ProductForm;
