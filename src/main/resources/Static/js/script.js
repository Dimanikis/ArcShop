async function goToURL(url) {
  let response = await fetch("https://arc-shop.herokuapp.com/acc/register", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({"name" : "user123", "password" : "123"}),
  });
  let result = await response.json();
  alert(result);
}
