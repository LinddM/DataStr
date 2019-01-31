public class Operations {

    public Transaction [] credt=new Transaction[5];
    public Transaction [] debt=new Transaction[10];

    public int countC=0, countD=0;
    public int availableC=0, availableD=0;

    void add(Transaction t){
            if (t.type=='c'){
                for (int i=0; i<5; i++){
                    if (credt[i]==null){
                        credt[i]=t;
                        countC++;
                        availableC++;
                        break;
                    }
                }
            }
            if (t.type=='d'){
                for (int i = 0; i < 10; i++) {
                    if (debt[i]==null) {
                        debt[i]=t;
                        countD++;
                        availableD++;
                        break;
                    }
                }
            }
    }

    void delete(int code, char type){
        if (type=='c'){
            for (int i=0; i<5; i++){
                if (credt[i].code==code){
                    credt[i]=null;
                    countC++;
                    availableC--;
                    break;
                }
            }
        }
        if (type=='d'){
            for (int i=0; i<5; i++){
                if (debt[i].code==code){
                    debt[i]=null;
                    availableD--;
                    countD++;
                    break;
                }
            }
        }
    }

    int TotalD(){
        int Tdebt=0;
        if (availableD>0){
            for (int i=0; i<10;i++){
                Tdebt+=debt[i].amount;
            }
        }
        return Tdebt;
    }

    int TotalC(){
        int TCredt=0;
        if (availableC>0){
            for (int i=0; i<5;i++){
                TCredt+=credt[i].amount;
            }
        }
        return TCredt;
    }

    int averageC(){
        int av=0;
        if (availableC!=0){
            av=TotalC()/availableC;
        }
        return av;
    }

    int averageD(){
        int av=0;
        if (availableD!=0){
            av=TotalD()/availableD;
        }
        return av;
    }

    int maxC(){
        int first=0;
        if (availableC>0){
            for (int i=0; i<5;i++){
                if (credt[i].amount>first){
                    first=credt[i].amount;
                }
            }
        }
        return first;
    }

    int maxD(){
        int first=0;
        if (availableD>0){
            for (int i=0; i<10;i++){
                if (debt[i].amount>first){
                    first=debt[i].amount;
                }
            }
        }
        return first;
    }
}
