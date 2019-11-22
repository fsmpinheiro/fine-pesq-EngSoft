<template>
    <div class="wrapper">
        <div class="footer">
            <div class="message">
                <p>Sistema desenvolvido para a cadeira de Eng. de Software - semestre 2019.2</p>
                <p>Os dados aqui cadastrados sãoutilizados apenas para fins acadêmicos</p>
                <p>Desenvolvidopor: Samuel M. Pinheiro</p>
            </div>
        </div>
    </div>
</template>


<script>
export default {
    name: "NeutralFooter"
}
</script>

<style scoped>
.footer{
    margin-top: 30px;
    padding: 15px 0; 
    text-align: center;
    background-color: #cfaf86;
}
.message{
    margin-top: 5px;
}
.message p{
    margin: 0;
    color: #fff;
    font-size: 15px;
    font-weight: bold;
    font-family: Roboto, sans-serif;
}
</style>