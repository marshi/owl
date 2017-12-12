<template>
  <div id="app">
    <svg viewbox="0 0 300 300" width="300" height="300">
      <line :x1="x1" y1=100 x2=200 y2=200 stroke="black"></line>
    </svg>
    <form>
      <input type="range" v-model="x1">
    </form>
  </div>
</template>