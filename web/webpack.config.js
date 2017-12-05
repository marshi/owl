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
    rules: [{
      // ローダーの処理対象ファイル
      test: /\.js$/,
      // ローダーの処理対象から外すディレクトリ
      exclude: /node_modules/,
      // 利用するローダー
      use: [{
        loader: 'babel-loader',
        options: {
          presets: ['env']
        }
      }]
    }]
  },
  plugins: [
    new webpack.optimize.CommonsChunkPlugin({
      name: 'vendor',
      chunks: ['test', 'test2']
    })
  ]
}
