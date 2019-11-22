<template>
    <div class="wrapper">
        <div class="body">
            <p class="message">Para começar o seu cadastro, por favor identifique-se</p>
            <form id="cpf-form"  action="" method="post">
                <p class="message">CPF:
                <the-mask :mask="['###.###.###-##']" id="cpf-field" v-model="cpf" type="text" name="cpf" placeholder="Digite seu CPF" required />
                <!-- <input id="cpf-field" v-model="cpf" type="text" name="cpf" placeholder="Digite seu CPF" required> --></p><br>
                <input id="cpf-submit" type="submit" value="Enviar">

                <!-- Utilizar aqui também dois scripts:
                    1- Uma máscara para formatar os números digitados no padrão de CPF
                    2- Um script para consultar se o CPF digitado já existe no banco de dados  -->
            </form>
        </div>
    </div>
    
</template>



<script>
import {TheMask} from 'vue-the-mask'

export default {
    name: 'CpfQuery',
    
    components: {
        TheMask
    }
}
</script>

<style scoped>
.body{
    margin-top: 20px;
    text-align: center;
    border: 1px black solid;
    border-radius: 10px;
    min-height: 320px;
    background-color: #dfdfff;
}

#cpf-field{
    height: 35px;
    width: 240px;
    border-radius: 10px;
    text-align: center;
    font-size: 25px;
    font-family: Roboto, sans-serif;
}
#cpf-submit{
    height: 48px;
    width: 160px;
    font-size: 22px;
    border-radius: 5px;
}

.message , .message p , .cpf-field{
    margin: 45px 0;
    color: #000;
    font-size: 28px;
    font-family: Roboto, sans-serif;
    text-shadow: 2px 2px 2px #797979;
}

</style>