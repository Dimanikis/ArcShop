let User = {
  login: "user1",
  password: "1234",
};
let signIn = true;

async function request(url) {
  console.log(User);
  let response = await fetch(`http://arc-shop.herokuapp.com/${url}`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(User),
  });
  let result = await response.json();
  console.log(result);
  console.log(response);
}
async function submit() {
  if (signIn) {
    await request("perform_login");
  } else {
    await request("/acc/register");
  }
}
