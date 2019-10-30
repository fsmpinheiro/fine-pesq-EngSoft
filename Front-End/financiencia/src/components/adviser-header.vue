<template>
    <div class="wrapper">
        <nav class="top-header">
            <div id="wellcome"><p>Financiência - Bem Vindo ao Portal do Assessor</p></div>
            <div id="link"><router-link to="researcherhome">Portal do Pesquisador</router-link></div>
        </nav>
    </div>
</template>

<script>
export default {
    name: 'AdviserTopHeader'
}
</script>

<style scoped>
.top-header{
    height: 70px;
    background-color: #9b59b6;
    display: flex;
}
.top-header #wellcome{
    width: 70%;
    margin: 18px 0 0 0 ;
}
.top-header #wellcome p{
    padding-left: 32px;
    text-shadow: 2px 2px 2px #693c7a;
}
.top-header #link{
    width: 30%;
    margin: 18px 0 0 0 ;
    text-align: right;
    padding-right: 32px;
}
.top-header #link a{
    background-color: #2ecc71;
    padding: 5px 10px;
    border: 2px #fff solid;
    border-radius: 8px;
    text-decoration: none;
}
.top-header p , .top-header a{
    margin: 0;
    color: #fff;
    font-size: 28px;
    font-weight: 700;
    font-family: Roboto, sans-serif;
}
</style>