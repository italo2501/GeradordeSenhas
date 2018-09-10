package geradordesenhas.granbery.br.geradordesenhas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private PasswordGenerator generator = new PasswordGenerator();
    private Button gerarSenha;
    private EditText tamanho;
    private TextView senha;
    private Switch numeros;
    private Switch simbolos;
    private Switch minusculo;
    private Switch maiusculo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tamanho = findViewById(R.id.tamanhoEdit);
        senha = findViewById(R.id.senhaText);
        gerarSenha = findViewById(R.id.buttonGerar);
        numeros = findViewById(R.id.switchNumeros);
        simbolos = findViewById(R.id.switchSimbolos);
        minusculo = findViewById(R.id.switchMinuscolas);
        maiusculo = findViewById(R.id.switchMaiusculas);
        senha .setText("");



        gerarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {







                 if(numeros.isChecked()){
                     generator.setIncludeNumbers(true);
                 }else{
                     generator.setIncludeNumbers(false);
                 }
                 if (simbolos.isChecked()){
                     generator.setIncludeSymbols(true);
                 }else{
                     generator.setIncludeSymbols(false);
                 }
                 if(minusculo.isChecked()){
                     generator.setIncludeLowerCase(true);
                 }else{
                     generator.setIncludeLowerCase(false);
                 }
                  if(maiusculo.isChecked()){
                     generator.setIncludeUpperCase(true);
                  }else{
                     generator.setIncludeUpperCase(false);
                  }


                generator.setSize(Integer.parseInt(tamanho.getText().toString()));
                senha.setText(generator.generate());

            }
        });

    }
}
