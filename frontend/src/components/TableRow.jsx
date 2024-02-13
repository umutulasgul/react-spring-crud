function TableRow({ cells }) {
  return (
    <tr>
      {cells.map((cell, index) => (
        <td key={index}>{cell}</td>
      ))}
    </tr>
  );
}

export default TableRow;
