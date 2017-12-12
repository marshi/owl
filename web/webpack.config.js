const path = require('path')
const webpack = require('webpack')

module.exports = {
  // エントリーポイントの設定
  entry: {
    test: './src/main/js/test.js',
    test2: './src/main/js/test2.js'
  },
  // 出力の設定
  output: {
    // 出力するファイル名
    filename: '[name].bundle.js',
    path: path.join(__dirname, 'src/main/resources/static/js')
  },
  // ローダーの設定
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        use: [{
          loader: 'babel-loader',
          options: {
            presets: ['env']
          }
        }]
      },
      {
        test: /\.vue$/,
        loader: 'vue-loader'
      }
    ]
  },
  resolve: {
    extensions: ['.js', '.vue'],
    modules: [
      "node_modules"
    ],
    alias: {
      vue: 'vue/dist/vue.common.js'
    }
  },
  plugins: [
    new webpack.optimize.CommonsChunkPlugin({
      name: 'vendor',
      chunks: ['test', 'test2']
    })
  ]
}
