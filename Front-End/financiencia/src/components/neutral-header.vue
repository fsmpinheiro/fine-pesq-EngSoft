<template>
    <div class="wrapper">
        <nav class="top-header">
            <div id="link">
                <router-link to="researcherhome">VOLTAR</router-link>
            </div>
            <div id="message">
                <router-link to="researcherhome">Financiência</router-link>
            </div>
        </nav>
    </div>

</template>

<script>
export default {
    name: 'NeutralHeader'
}
</script>

<style scoped>
.top-header{
    height: 70px;
    background-color: #ff9100;
    display: flex;
}
.top-header a{
    text-decoration: none;
}
.top-header #link{
    margin: 18px 0 0 0;
    text-align: left;
    padding-left: 32px;
}
.top-header #link a{
    background-color: rgb(255, 89, 89);
    padding: 5px 20px;
    border: 2px #fff solid;
    border-radius: 8px;  
}
.top-header #message{
    align-content: right;
    margin: 18px 0 0 0;
}
.top-header #message a{
    margin-left: 350px;
    align-content: left;
    text-shadow: 2px 2px 2px #693c76;
}
.top-header p, .top-header a{
    margin: 0;
    color: #fff;
    font-size: 28px;
    font-weight: 700;
    font-family: Roboto, sans-serif;    
}
</style>