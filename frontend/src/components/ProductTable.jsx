import Table from "./Table";
import TableRow from "./TableRow";
import useProducts from "../hooks/useProducts.jsx";

function ProductTable() {
  const { products, loading, error } = useProducts();

  if (loading) {
    return <h2>Loading...</h2>;
  }

  if (error) {
    return <h2>Product not found: {error}</h2>;
  }

  return (
    <Table header={["Name", "Category", "Brand", "Price", "Description"]}>
      {products.map((product) => (
        <TableRow
          key={product.id}
          cells={[
            product.name,
            product.category,
            product.brand,
            product.price,
            product.description,
          ]}
        />
      ))}
    </Table>
  );
}

export default ProductTable;
