const { merge } = require('webpack-merge');
const common = require('./webpack.common.js');
const path = require('path');

module.exports = (env, options) =>
  merge(common(env, options), {
    mode: 'development',
    devtool: 'eval-cheap-source-map',
    devServer: {
      historyApiFallback: true,
      port: 3000,
      hot: true,
    },
    output: {
      path: path.join(__dirname, '../build'),
      publicPath: '/',
      filename: 'bundle.js',
    },
  });
