// composeApp/webpack.config.d/spa-fallback.js
if (!config.devServer) {
    config.devServer = {};
}

// Enable history API fallback so SPA routes like /login or /dashboard work
config.devServer.historyApiFallback = {
    index: '/index.html'
};
