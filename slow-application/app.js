const express = require("express");
const app = express();
const port = 3000;

app.get("/samples/:id", (req, res) => {

  setTimeout( function(){ res.send({ id: req.params.id, details: "Sample details" }); }, 2000);
});

app.listen(port, () => {
  console.log(`Slow app listening at http://localhost:${port}`);
});