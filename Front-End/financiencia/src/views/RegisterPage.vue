<template>
    <div class="wrapper">
        <div class="register">
            <NeutralHeader />
            <CpfQuery />
            <NeutralFooter />
        </div>
    </div>
</template>

<script>
import NeutralHeader from '../components/neutral-header.vue'
import CpfQuery from '../components/cpf-query-body.vue'
    import NeutralFooter from '../components/neutral-footer.vue'

export default {
    name: 'RegisterPage',
    components: {
        NeutralHeader,
        CpfQuery,
        NeutralFooter
    }    
}
</script>
