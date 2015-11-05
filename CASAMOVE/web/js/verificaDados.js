//Máscaras
function mascara(o,f){
    v_obj=o;
    v_fun=f;
    setTimeout("execmascara()",1);
}

function execmascara(){
    v_obj.value=v_fun(v_obj.value);
}


function vcnpj(v){
    v=v.replace(/\D/g,"");                    //Remove tudo o que não é dígito
    v=v.replace(/(\d{2})(\d)/,"$1.$2");       //Coloca um ponto entre o terceiro e o quarto dígitos
    v=v.replace(/(\d{3})(\d)/,"$1.$2");      //Coloca um ponto entre o terceiro e o quarto dígitos
    v=v.replace(/(\d{3})(\d)/,"$1/$2");      //Coloca uma barra
    //de novo (para o segundo bloco de números)
    v=v.replace(/(\d{4})(\d{1,2})$/,"$1-$2"); //Coloca um hífen antes dos 2 ultimos
    return v;
}
// verifica senha
function validaSenha (input){ 
                 
                    if(input.lenght < 6){
                    input.setCustomValidity('Repita a senha com pelomenos 6 caracteres');
                        }
                    if (input.value != document.getElementById('isenha').value) {
                    input.setCustomValidity('Repita a senha corretamente');
                    } else {
                    input.setCustomValidity('');
                        }
             
                }
     