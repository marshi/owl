import Vue from 'vue'

var v = new Vue({
  el: '#app',
  template: '<div id="app">{{message}}</div>',
  data: {
    message: "aieuo"
  }
})

v.$data.message = "iii"