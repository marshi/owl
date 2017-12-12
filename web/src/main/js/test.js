import Vue from 'vue'
import App from './App'

var v = new Vue({
  el: '#app',
  // template: "<App></App>",
  // components: { App },
  data: {
    message: "aieuo",
    x1: 100
  }
})

v.$data.message = "iii"