String directory = System.getProperty("user.home");
String fileName = "sample.txt";
String absolutePath = directory + File.separator + fileName;

// Write the content in file 
try(FileWriter fileWriter = new FileWriter(absolutePath)) {
    String fileContent = "This is a sample text.";
    fileWriter.write(fileContent);
    fileWriter.close();
} catch (IOException e) {
    // Cxception handling
}

// Read the content from file
try(FileReader fileReader = new FileReader(absolutePath)) {
    int ch = fileReader.read();
    while(ch != -1) {
        System.out.print((char)ch);
        fileReader.close();
    }
} catch (FileNotFoundException e) {
    // Exception handling
} catch (IOException e) {
    // Exception handling
}
