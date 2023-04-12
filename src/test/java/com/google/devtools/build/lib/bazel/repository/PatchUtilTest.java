public class PatchUtilTest {
  private FileSystem fs;
  private Scratch scratch;
  public final void initializeFileSystemAndDirectories() throws Exception {
    fs = new InMemoryFileSystem(DigestHashFunction.SHA256);
    scratch = new Scratch(fs, "/root");
    assertThat(PatchUtil.readFile(newFile)).containsExactlyElementsIn(newFileContent);
    assertThat(PatchUtil.readFile(newFile)).containsExactlyElementsIn(newFileContent);
    assertThat(PatchUtil.readFile(oldFile)).isEmpty();
    assertThat(PatchUtil.readFile(oldFile)).containsExactlyElementsIn(newContent);
    assertThat(PatchUtil.readFile(newFile)).containsExactly("line one");
    assertThat(PatchUtil.readFile(newFile)).containsExactlyElementsIn(newContent);
    assertThat(PatchUtil.readFile(myFile)).containsExactly("line one");
    assertThat(PatchUtil.readFile(foo)).containsExactlyElementsIn(newFoo);
    assertThat(PatchUtil.readFile(bar)).containsExactlyElementsIn(newBar);
    assertThat(PatchUtil.readFile(fooCpp)).containsExactlyElementsIn(newFoo);
    assertThat(PatchUtil.readFile(barCpp)).containsExactlyElementsIn(newBar);
    assertThat(PatchUtil.readFile(foo)).containsExactlyElementsIn(newFoo);
    assertThat(PatchUtil.readFile(foo)).containsExactlyElementsIn(newFoo);
  @Test
  public void testMissingBothOldAndNewFile() throws IOException {
    Path patchFile =
        scratch.file(
            "/root/patchfile",
            "diff --git a/ b/",
            "index f3008f9..ec4aaa0 100644",
            "@@ -2,4 +2,5 @@",
            " ",
            " void main(){",
            "   printf(\"Hello foo\");",
            "+  printf(\"Hello from patch\");",
            " }");
    PatchFailedException expected =
        assertThrows(PatchFailedException.class, () -> PatchUtil.apply(patchFile, 1, root));
    assertThat(expected)
        .hasMessageThat()
        .contains("Wrong patch format near line 3, neither new file or old file are specified.");
  }

  public void testWrongChunkFormat1() throws IOException {
  public void testWrongChunkFormat2() throws IOException {
  public void testWrongChunkFormat3() throws IOException {