package com.example.suzane.test;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Game extends AppCompatActivity implements View.OnClickListener {
    Button bVerif;
    Button bAide;
    TextView textViewN;
    TextView textViewMots;
    SharedPreferences sf;
    public static final String pref = "pref";
    public static final String scoreSh = "score";
    TextView textViewA;
    TextView textViewB;
    EditText editTextMot;
    int i=0;
    int r;
    int z;
    String score;
    String ex;
    String deviner;
    int trou;//A
    int pou;//B
    String a;

    String b;
    String b1;
    String b2;
    String b3;
    
    String dictionaire[] = {"aboi","abot","abri","abus","aces","acme","acne","acon","acre","acte","adne","ados","afin","afro","agio","agir","agis","agit","agui","agit","bAide","bAide","aies","aigu","aile","ails","aile","aime"
            ,"aime","aine","aire","airs","aire","aise","aisy","aise","ales","aloi","alpe","alto","alun","amen","amer","amie","amis","amui","ange","anis","anse","anse",
            "ante","anus","aout","apex","apis","apte","arcs","ardt","ardu","arec","ares","arme","arme","arts","arum","aspe","asti","aube","auge","aune","auto","avec","aven","aveu","avez","avis","axer","axes","axez","axis","axes","ayez","azur","aine","acre","ages","ages","ames","anes","apre","atre","bacs","baie","bail","bain","bais",
            "bals","banc","bang","bans","bard","barn","bars","base","base","bath","bats","baud","baux","bave","bave","baye","baye","beau","becs","bers","beur","beys","bics"
            ,"bide","bief","bien","bila","bile","bile","bina","bine","bine","bisa","bise","bise","bita","bite","bits","bite","bled","blet","bleu","bloc","bles","boas","bock ","bois","boit","bols","bond","boni","bons","bora","bord","bore","bort","bote","bots","bouc","boue","boul","boum","bous","bout","boxa","boxe","boxe","boys","brai","bran","bras","bref","bric","brie","brin","brio","bris","broc","brou","brui",
            "brun","brus","brut","bues","buis","buna","bure","busc","buse","bush","buta","bute","buts","bute","bate","bati","bate","beai","beas","beat","begu","beni","beat"
            ,"bela","beta","bome","cabs","cade","cadi","cafe","cage",
            "cake","cale","calf","calo","cals","cale","came","camp","cane","cane","cape","caps","cape","cari","cars","case","cash","case","cati","cave","cave","caid","cela"
            ,"cens","cent","ceps","cerf","ceux","chai","char","chas","chat","chef","cher","chez","chia","chie","chie","chou","chue","chus","chut","chut","ciao","ciel","cils ","cime","cinq","cine","cira","cire","cire","cita","cite","cite","clam","clan","clef","clin","clip","clos","clou","club","cles","clot","coda","code","code","coin","cois","coke","cola","cols","colt","coma","conf","cons","coqs","cors","cosy",
            "cota","cote","coti","cote","coud","coup","cour","cous","coit","cout","cran","cria","crie","crin","cris","crie","crue","crus","crut","crea","crus","crut","cuba"
            ,"cube","cube","cuir","cuis","cuit","cula","cule","culs","cule","cura","cure","cure","cuti","cuva","cuve","cuve","cyan","czar","ceda","cone","coni","cote","cote ","daim","dais","dame","dame","dans","date","date","dela","demi","dent","deux","deys","deca","dico","dieu","ding","dira","dire","dise","dite","dito","dits","diva","dock","doge","dois","doit","dola","dole","dols","dole","donc","dons","dont",
            "dopa","dope","dope","dora","dore","dors","dort","dore","dosa","dose","dose","dota","dote","dots","dote","doua","doue","doum","doux","doue","drap","drop","drue"
            ,"drus","dual","duce","ducs","duel","dues","duit","dune","duos","dupa","dupe","dupe","dura","dure","durs","dure","deca","deci","defi","deja","deni","decu","dime ","dina","dine","dine","dome","eaux","embu","enta","ergs","euro",
            "exil","exit","Eric","ebat","echo","echu","ecot","ecru","ecus","edam","edit","egal","elan","elis","elit","elus","elut","elut","emia","emir","emis","emit","emoi"
            ,"emou","emus","emut","emit","emut","eons","epar","epia","epis","eros","etai","etal","etau","etoc","etui","face","fade","fado","fade","faim","fais","fait","fame ","fane","fane","faon","fard","faro","fars","fart","fats","faut","faux","faxe","faxe","fend","fera","fers","feus","feux","fias","fiat","fics","fiel","fier","fies","fieu","fiez","fige","fige","fila","file","film","fils","file","fine","fins",
            "fion","fisc","fixa","fixe","fixe","fiat","fies","flac","flan","flic","floc","flop","flot","flou","flua","flue","flux","flue","focs","foie","foin","fois","folk"
            ,"fols","fond","font","fora","fore","fors","fort","fore","foui","four","fous","fout","foxe","frac","frai","fret","fric","fris","frit","froc","frit","fuel","fuie ","fuir","fuis","fuit","fuma","fume","fume","fusa","fuse","fuse","fute","fuit","feal","fera","feru","fetu","fevr","fela","feta","futs","gade","gaie","gain","gais","gale","gals","gant","gaps","gare","gars","gare","gaur","gave","gave","gays",
            "gaze","gaze","geai","gela","gels","gens","gent","gins","girl","glas","glui","glus","gnou","goal","goba","gobe","gobe","goda","gode","gode","golf","gond","gord"
            ,"goum","gour","goim","gout","gras","grau","grec","gril","gris","gros","grue","gres","grea","guai","guet","guis","guea","gues","gyms","gate","gate","gemi","gera ","gena","gita","gite","gite","haie","hais","hait","hale","halo","hale","haro","hart","hase","hast","haut","have","havi","have","haie","haik","hair","hais","hait","hein","heur","hier","hies","hoir","hola","home","hors","houa","houe","houp",
            "houx","houe","huai","huas","huer","hues","huez","huis","huit","huma","hume","hume","hune","hure","huat","hues","hale","hale","hate","hate","have","hela","hote","idem","ides","igne","igue","imbu",
            "inca","inde","indu","inox","insu","ioda","iode","iode","ions","iota","iras","ires","irez","isba","item","itou","iule","ives","ivre","iles","ilot","jack","jade"
            ,"jais","jale","jans","janv","jars","jase","jase","jain","jean","jerk","jeta","jets","jeun","jeux","jobs","joie","joli","jonc","jota","joua","joue","joug","joui ","jour","joue","jube","judo","juge","juge","juif","juin","jupe","jura","jure","jury","jure","juta","jute","jute","kali","kami","kans","kart","khan","khat","khol","kief","kifs","kilo","kils","kilt","kirs","kits","kola","kore","ksar","kvas",
            "kwas","kepi","lace","lacs","lace","lads","lady","laid","laie","lais","lait","lame","lame","land","lape","laps","lape","lard","lave","lave","laye","laye","laic"
            ,"legs","lent","lest","leur","leva","lias","lice","lido","lied","lien","lier","lies","lieu","liez","lift","lige","lima","lime","lime","lino","lion","lira","lire ","lise","lita","lite","lits","lite","live","liat","lies","loba","lobe","lobs","lobe","loch","lods","lofa","lofe","lofs","loft","lofe","loge","loge","loin","loir","lois","long","lord","lori","lors","lote","loti","lots","loua","loue","loup",
            "loue","lova","love","love","lues","luge","luge","luis","luit","lump","lune","lune","luta","lute","luth","lute","luxa","luxe","luxe","lynx","lyre","lysa","lyse"
            ,"lyse","lesa","mach","macs","mage","maie","mail","main","mais","maki","mali","malt","mans","marc","mare","mari","mark","mars","mate","math","mati","mats","mate ","maux","maye","mais","mecs","mena","mens","ment","menu","mers","mesa","mets","meus","meut","mica","miel","mien","mies","mile","mils","mina","mine","mine","mira","mire","miro","mirs","mire","misa","mise","mise","mita","mite","mite","mixa",
            "mixe","mixe","mode","mois","moka","mols","moly","mont","mord","more","mors","mort","mots","moud","moue","mous","moxa","moye","mout","muai","muas","muer","mues"
            ,"muet","muez","muge","mugi","muid","mule","muni","mura","mure","murs","mure","musa","musc","muse","must","muse","muta","mute","mute","muat","mues","male","mate ","mats","mate","meat","megi","melo","meta","mela","mole","mure","muri","murs","nafe","nage","nage","nais","naos","nard","nase","nazi","nait","naif","neck","nefs","nerf","nets","neuf","nias","nids","nier","nies","niez","nife","nifs","nixe",
            "niat","nies","noce","noie","noir","noix","nome","noms","nopa","nope","nope","nord","nota","note","note","noua","noue","nous","noue","nova","nove","nove","noya"
            ,"noye","noel","nuai","nuas","nuer","nues","nuez","nuis","nuit","nuls","nuat","nues","obel","obit","obus","obei","ocra","ocre","ocre","odes","oeil","oeuf","ogre ","ohms","oies","oing","oint","olim","omet","omis","omit","omit","once","onde","onde","onyx","onze","open","opes","opta","opte","opte","opus","oral","orbe","ores","orge","orin","orle","orme","orna","orne","orne","osai","oser","osez","osat",
            "oued","ours","oust","ouie","ouir","ouis","ouit","oves","ovin","ovni","oyat","otai","otas","oter","otes","otez","otes","pack","page","page","paie","pain","pair"
            ,"pais","paix","pale","pals","pane","pans","pane","paon","parc","pare","pari","pars","part","paru","pare","pave","pave","paye","pays","paye","pait","peau","pela ","pend","perd","pers","pesa","peso","peuh","peul","peur","peut","peux","piaf","pian","pica","pics","pied","pies","pieu","pifa","pife","pifs","pife","pige","pige","pila","pile","pile","pins","pion","pire","pise","pite","pive","plan","plat",
            "plia","plie","plis","plie","ploc","plot","plus","plut","plut","pneu","poil","pois","poix","poli","pond","pont","porc","pore","port","posa","pose","pose","pote"
            ,"pots","pouf","pour","poux","pria","prie","pris","prit","prix","prie","prof","pros","prou","pres","pref","pres","pret","prit","puai","puas","pubs","puce","puer ","pues","puez","puis","puma","puna","puni","punk","pure","purs","pute","puys","puat","pues","pale","pali","pame","pame","pate","pati","pate","pean","peon","peri","peta","pole","quai","quel","quoi","race","race","rade","rade","rage","rage",
            "raid","raie","rail","rais","raki","rame","rami","rame","rang","rani","ranz","rapt","rase","rash","rase","rate","rats","rate","rave","ravi","raye","raye","redu"
            ,"regs","rein","reis","relu","rems","rend","reps","repu","rets","revu","recu","rhum","rhes","rial","rias","rida","ride","ride","riel","rien","ries","riez","rift ","rima","rime","rime","ring","ripa","ripe","ripe","rite","riva","rive","rive","rixe","roba","robe","robs","robe","rock","rocs","roda","rode","rode","rois","rond","rosa","rose","rosi","rose","rota","rote","rots","rote","roua","roue","rouf",
            "roui","roux","roue","ruai","ruas","rude","rues","ruez","rugi","rusa","ruse","rush","ruse","ruts","ruat","rues","rale","rale","rape","rape","reac","reai","real"
            ,"reas","regi","reat","reva","roda","rode","rode","role","roti","rots","sage","sain","sait","saki","sake",
            "sale","sali","sale","sang","sape","sape","sari","sati","sauf","saur","saut","saxe","saxo","scat","scia","scie","scie","seau","sein","self","sema","sent","sept"
            ,"sera","serf","sert","seul","sexy","show","sial","sied","sien","silo","sima","sire","site","sium","skia","skie","skif","skie","slip","slow","smog","snob","soda ","sode","sofa","soie","soif","soin","soir","soit","soja","sole","soli","soma","sont","sore","sort","soue","souk","soya","soul","spot","star","stem","stop","stuc","suai","subi","suce","suce","suer","suez","suie","suif","suit","suiv","sure",
            "surf","suri","suat","suca","swap","sevi","sure","tacs","taie","tain","tais","talc","tale","tale","tank","tans","taon","tape","tapi","tape","tard","tare","tari"
            ,"tare","taux","taxe","taxi","taxe","teck","teks","tels","tend","tenu","thon","thym","thes","tian","tics","tien","tifs","tige","tins","tira","tire","tirs","tire ","tisa","tise","tise","tocs","toge","tolu","toma","tome","tome","tond","tons","topa","tope","tops","tope","tord","tors","tory","toua","toue","tour","tous","toux","toue","trac","tram","tria","trie","trin","trio","trip","tris","trie","troc",
            "trop","trou","truc","tres","tsar","tuai","tuas","tuba","tube","tubs","tube","tuer","tues","tuez","tufs","tune","tupi","turc","turf","tues","typa","type","typo"
            ,"type","tzar","tenu","tole","ubac","ulve","unes","unie","unir","unis","unit","unit","upas","ures","urge","urge","urne","usai","user","usez","usat","uval","vagi ","vain","vair","vais","vals","valu","vamp","vans","vape","vars","vase","vaut","vaux","veau","veld","velu","vend","vent","venu","vers","vert","veto","veuf","veut","veux","vexa","vice","vida","vide","vide","vies","vifs","vile","vils","vina",
            "vine","vins","vint","vine","vioc","viol","vira","vire","vire","visa","vise","vise","vite","vlan","voeu","voie","voir","vois","voit","voix","vola","vole","vols"
            ,"volt","vole","vomi","vont","vota","vote","vote","voua","voue","vous","voue","vrac","vrai","vues","vecu","velo","vela","vets","vetu","vint","whig","zain","zani ","zend","ziba","zibe","zibe","zigs","zinc","zona","zone","zone","zebu","zero","zeta","yack","yaks","yang","yard","yens","yeux","yoga","yogi","yole"};
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        score = intent.getStringExtra("score");


        bVerif = (Button) findViewById(R.id.bVerif);
        bAide = (Button) findViewById(R.id.bAide);
        editTextMot = (EditText) findViewById(R.id.editTextMot);
        textViewN = (TextView) findViewById(R.id.textViewN);
        textViewMots = (TextView) findViewById(R.id.textViewMots);
        textViewB = (TextView) findViewById(R.id.textViewB);
        textViewA = (TextView) findViewById(R.id.textViewA);
        bVerif.setOnClickListener(this);
        bAide.setOnClickListener(this);
        sf = getSharedPreferences(pref, Context.MODE_PRIVATE);


        Random random = new Random();
        r = random.nextInt(1674);//le mot choisi
        deviner= dictionaire[r];
        Log.d("le mot deviner est :", deviner);
    }

    public void test(String aa){// si le mot existe dans le dictionaire
        //Toast.makeText(getApplicationContext(), "1111111111111", Toast.LENGTH_SHORT).show();
        int ax= dictionaire.length;
        z = 0;
        Log.d("longeur du dictionaire", String.valueOf(dictionaire.length));
        int j =1;
        while (j<ax){
            if (aa.equals(dictionaire[j]) ){

                z =1;
                Log.d("lkaaaaaaaaaaah", String.valueOf(z));
                MediaPlayer mp = MediaPlayer.create(Game.this,R.raw.core);
                mp.start();
                Toast.makeText(getApplicationContext(), "existe dans dictionaire",
                        Toast.LENGTH_SHORT).show();
                j=ax;
            }
            j++;
        }

 
    if (z==1){
        turing(aa);
    }else {
        MediaPlayer mp = MediaPlayer.create(Game.this,R.raw.incore);
        mp.start();
        Toast.makeText(getApplicationContext(), "Mot invalide",//existe pa dans dictionaire
                Toast.LENGTH_SHORT).show();
    }

    }

    public void turing(String bb){
        //pour suprimer les 3 premier lettre dun string finalnum = finalnum.substring(3);
        char bb1 = bb.charAt(0);
        char bb2 = bb.charAt(1);
        char bb3 = bb.charAt(2);
        char bb4 = bb.charAt(3);

        char dd1 = deviner.charAt(0);
        char dd2 = deviner.charAt(1);
        char dd3=  deviner.charAt(2);
        char dd4 = deviner.charAt(3);

        if (bb1==dd1){
            trou=trou+1;
        }
        if (bb1==dd2){
            pou=pou+1;
        }
        if (bb1==dd3){
            pou=pou+1;
        }
        if (bb1==dd4){
            pou=pou+1;
        }
        if (bb2==dd1){
            pou=pou+1;
        }
        if (bb2==dd2){
            trou=trou+1;
        }
        if (bb2==dd3){
            pou=pou+1;
        }
        if (bb2==dd4){
            pou=pou+1;
        }
        if (bb3==dd1){
            pou=pou+1;
        }
        if (bb3==dd2){
            pou=pou+1;
        }
        if (bb3==dd3){
            trou=trou+1;
        }
        if (bb3==dd4){
            pou=pou+1;
        }
        if (bb4==dd1){
            pou=pou+1;
        }
        if (bb4==dd2){
            pou=pou+1;
        }
        if (bb4==dd3){
            pou=pou+1;
        }
        if (bb4==dd4){
            trou=trou+1;
        }

    resultat(trou,pou);

    }

    public void resultat(int tro,int po){
        String c = b + "\n"+i;
        String c1 = b1 + "\n"+a;
        String c2 = b2 + "\n"+String.valueOf(tro);
        String c3 = b3 + "\n"+String.valueOf(po);
        textViewN.setText(c);
        textViewMots.setText(c1);
        textViewA.setText(c2);
        textViewB.setText(c3);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bVerif) {
            a = editTextMot.getText().toString();//edit text le mot ecri
            editTextMot.setText("");
            trou=0;
            pou=0;

            if (a.length() == 4){
                char z0 = a.charAt(0);
                char z1 = a.charAt(1);
                char z2 = a.charAt(2);
                char z3 = a.charAt(3);
                if (z0 == z1 || z0 == z2 || z0 == z3 || z1 == z2 || z1 == z3 || z2 == z3) {
                    MediaPlayer mp = MediaPlayer.create(Game.this,R.raw.incore);
                    mp.start();
                    Toast.makeText(getApplicationContext(), "Mot invalide",
                            Toast.LENGTH_SHORT).show();
                }else{
                    i++;
                    if (i>15){
                        MediaPlayer mp = MediaPlayer.create(Game.this,R.raw.over);
                        mp.start();
                        showErrorMessage();
                    }else{
             b = textViewN.getText().toString();//list de num
             b1 = textViewMots.getText().toString();//list de mo
             b2 = textViewA.getText().toString();//list de A
             b3 = textViewB.getText().toString();//list de B


            // voir ici si le mot inséré est le mot deviner
                if (a.equals(deviner)){
                    int zeta = Integer.parseInt(score);
                    zeta++;
                    score = String.valueOf(zeta);
                    SharedPreferences.Editor editor = sf.edit();
                    editor.putString(scoreSh,score);
                    editor.commit();
                    MediaPlayer mp = MediaPlayer.create(Game.this,R.raw.win);
                    mp.start();
                    showWinningMessage();
                }else {
                    //sinon faire le test
                    test(a);
                }


        }
        }
            }else{
                MediaPlayer mp = MediaPlayer.create(Game.this,R.raw.incore);
                mp.start();
                Toast.makeText(getApplicationContext(), "Mot invalide",
                        Toast.LENGTH_SHORT).show();
            }
        }

        if (v.getId() == R.id.bAide) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Game.this);
            dialogBuilder.setMessage("Ceci est quelque mots de 4 lettres en Français : "+"\n"+"tige "+","+"bute "+","+"chie "+","+"noms "+","+"orna "+","+"faut "+","+"cafe "+","+"dope "+","+"nuit "+","+"aine "+","+"epar "+","+"foie "+","+
                    "gros "+"have "+","+"indu "+","+"joli "+","+
                    "kilt "+"lape "+","+"mage "+","+"nazi "+","+"ocre "+","+"pays "+","+"quoi "+","+"relu "+","+"sexy "+","+
                    "taxi "+"unis "+","+"vert "+","+"whig "+","+"zani "+","+"yoga ");
            dialogBuilder.setPositiveButton("ok",null);

            dialogBuilder.show();
        }

    }

    private void showWinningMessage() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Game.this);
        dialogBuilder.setMessage("vous venez de trouver le mot est c'est : "+deviner);
        dialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                Toast.makeText(getApplicationContext(), "Nouvelle Partie",
                        Toast.LENGTH_LONG).show();
                Intent i = new Intent(Game.this,MainActivity.class);


                startActivity(i);
                finish();
            }
        });
        dialogBuilder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {


                finish();
                System.exit(0);

            }
        });
        dialogBuilder.show();
    }

    private void showErrorMessage() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Game.this);
        dialogBuilder.setMessage("vous venez de perdre le mot est : "+deviner);
        dialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                Toast.makeText(getApplicationContext(), "Nouvelle Partie",
                        Toast.LENGTH_LONG).show();
                Intent i = new Intent(Game.this,MainActivity.class);

                startActivity(i);
                finish();

            }
        });
        dialogBuilder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {


                finish();
                System.exit(0);

            }
        });
        dialogBuilder.show();
    }
}
