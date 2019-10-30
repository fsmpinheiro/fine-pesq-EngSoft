<template>
    <div class="wrapper">
        <div class="body">
            <div class="celula">
                <div class="link">
                    <a href="#"><p>Cadastrar-se como Assessor no Financiência</p></a>
                </div>
            </div>
            <div class="celula">
                <div class="link">
                    <a href="#"><p>Avaliar Projetos de Pesquisadores</p></a>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'AdviserBody'
}
</script>

<style scoped>
.celula{
    width: 46%;
    min-height: 320px;
    background-color: blue;
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
    background-color: #3333fd;
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