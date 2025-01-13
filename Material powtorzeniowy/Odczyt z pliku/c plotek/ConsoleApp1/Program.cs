namespace ConsoleApp1
{
    internal class Program
    {
        static string[] lines;
        static void Main(string[] args)
        {
            lines = File.ReadAllLines("Data.txt");
            for(int i=0; i<lines.Length; i++)
            {
                Console.WriteLine(lines[i]);
            }
        }
    }
}