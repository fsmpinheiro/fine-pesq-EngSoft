<template>
    <div class="wrapper">
        <div class="main">
            <HeaderAdviser />
            <BodyAdviser />
            <NeutralFooter />
        </div>
    </div>
</template>


<script>
import HeaderAdviser from '../components/adviser-header.vue'
import BodyAdviser from '../components/adviser-body.vue'
import NeutralFooter from '../components/neutral-footer.vue'

export default {
    name: 'AdviserMain',
    components: {
        HeaderAdviser,
        BodyAdviser,
        NeutralFooter
    }
}
</script>

<style scoped>

</style>