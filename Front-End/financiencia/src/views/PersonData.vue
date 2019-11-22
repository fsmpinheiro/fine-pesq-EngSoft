<template>
    <div class="wrapper">
        <div class="profile">
            <NeutralHeader />


            <NeutralFooter />
        </div>
    </div>
</template>

<script>
import NeutralHeader from '../components/neutral-header.vue'

import NeutralFooter from '../components/neutral-footer.vue'


export default {
    name: 'PerfonalForm',
    components: {
        NeutralHeader,
        NeutralFooter
    }

}
</script>