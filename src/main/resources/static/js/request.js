export function get(url) {
  return new Promise((resolve, reject) => {
    var httpRequest = new XMLHttpRequest();
    if (!httpRequest) {
      alert("Giving up :( Cannot create an XMLHTTP instance");
      return false;
    }
    httpRequest.open("GET", url, true);
    httpRequest.send();
    httpRequest.onload = function () {
      if (alertContents(httpRequest)) {
        resolve(JSON.parse(httpRequest.responseText));
      } else {
        reject(new Error(httpRequest));
      }
    };
  });
}

export function post_old(url, request) {
  return new Promise((resolve, reject) => {
    console.log(url);
    console.log(request);
    var httpRequest = new XMLHttpRequest();
    if (!httpRequest) {
      alert("Giving up :( Cannot create an XMLHTTP instance");
      return false;
    }
    httpRequest.open("post", url, true);
    httpRequest.setRequestHeader("Content-type", "application/json");
    httpRequest.send(JSON.stringify(request));
    httpRequest.onload = function () {
      if (alertContents(httpRequest)) {
        // resolve(JSON.parse(httpRequest.responseText));
        resolve(JSON.stringify(httpRequest.responseText));
      } else {
        reject(new Error(httpRequest));
      }
    };
  });
}
export function post(url, data) {
  return new Promise((resolve, reject) => {
    console.log("post request:" + data + "\turl:" + url);
    var xhr = new XMLHttpRequest();
    xhr.open("post", url, true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(data);

    xhr.onload = function () {
      if (alertContents(xhr)) {
        resolve(JSON.parse(xhr.responseText));
      }else{
        reject(new Error(httpRequest));
      }
    };
  });
}
function alertContents(httpRequest) {
  if (httpRequest.status === 200) {
    return true;
  } else {
    console.log("There was a problem with the request.");
    return false;
  }
}
// export function getIp() {
//   $.getJSON("https://api.ipify.org?format=json", function (data) {
//     console.log(data.ip);
//     return data.ip;
//   });
// }
// export {get, post}
