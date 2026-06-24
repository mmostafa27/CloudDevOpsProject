terraform {
  backend "s3" {
    bucket = "mohamed-clouddevops-tfstate"
    key = "terraform.tfstate"
    region = "us-east-1"
   }

}
