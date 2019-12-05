const PROXY_CONFIG = [
  {
    context: ["/api"],
    target: "http://localhost:3000",
    secure: false,
    pathRewrite: { "^/api": "" },
    logLevel: "debug"
  }
];
module.exports = PROXY_CONFIG;
