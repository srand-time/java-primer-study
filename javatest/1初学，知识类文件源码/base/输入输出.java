import java.util.Scanner;
public class Scoreset{
	public static void main(String args[]){
	Scanner input=new Scanner(System.in);
	System.out.println("please input first score");
	int score1=input.nextInt();
	System.out.println("please input second score");
	int score2=input.nextInt();
	float score_1=score1;
	float score_2=score2;
	float higher=score_2/score_1;
	System.out.printf("higher rate=%4.2f",higher);
	}
}
