<template>
    <div class="wrapper">
        <div class="body">
            <div class="celula">
                <div class="link">
                <a href="#"><p>Cadastrar-se como Pesquisador no Financiência</p></a>
                </div>
            </div>
            <div class="celula">
                <div class="link">
                <a href="#"><p>Consultar Pesquisa cadastrada no sistema</p></a>
                </div>
            </div>     

        </div>
    </div>
</template>

<script>
export default {
    name: 'ResearcherBody'
}
</script>

<style scoped>
.celula{
    width: 46%;
    min-height: 320px;
    background-color: #a52a2a;
    margin: 25px 25px;
    float: left;
    border-radius: 10px;
}

.link{
    margin: 20% 15% 0 15%;
    width: 70%;
    color: #fff;
    font-size: 26px;
    font-weight: 700;
    font-family: Roboto, sans-serif;
    background-color: #922525;
    border-radius: 10px;

}

.link a{
    text-align: center;
    text-decoration: none;
    color: #fff;
    text-shadow: 2px 2px 2px #1c8045;
}
.link a p{
    padding: 4px 14px;  
}
</style>
