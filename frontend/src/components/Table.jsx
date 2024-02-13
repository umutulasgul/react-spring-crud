function Table({ header, children }) {
  return (
    <table>
      <thead>
        <tr>
          {header.map((cell, index) => (
            <th key={index}>{cell}</th>
          ))}
        </tr>
      </thead>
      <tbody>{children}</tbody>
    </table>
  );
}

export default Table;
