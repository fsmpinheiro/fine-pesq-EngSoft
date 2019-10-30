<template>
    <div class="wrapper">
        <div class="main">
            <HeaderAdviser />
            <BodyAdviser />
        </div>
    </div>
</template>


<script>
import HeaderAdviser from '../components/adviser-header.vue'
import BodyAdviser from '../components/adviser-body.vue'

export default {
    name: 'AdviserMain',
    components: {
        HeaderAdviser,
        BodyAdviser
    }
}
</script>

<style scoped>

</style>