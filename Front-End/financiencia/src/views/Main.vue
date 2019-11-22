<template>
  <div class="wrapper">
    <div class="main">
      <HeaderResearcher />
      <BodyResearcher />
      <NeutralFooter />
    </div>
  </div>
</template>

<script>
import HeaderResearcher from '../components/researcher-header.vue'
import BodyResearcher from '../components/researcher-body.vue'
import NeutralFooter from '../components/neutral-footer.vue'

export default {
  name: 'Main',
  components: {
    HeaderResearcher,
    BodyResearcher,
    NeutralFooter
    
  }
}
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
