module "network" {
  source = "./modules/network"
  project_name          = "ivolve"
  vpc_cidr              = "10.0.0.0/16"
  public_subnet_cidrs   = ["10.0.1.0/24", "10.0.2.0/24"]
  private_subnet_cidrs  = ["10.0.10.0/24", "10.0.20.0/24"]
  azs                   = ["us-east-1a", "us-east-1b"]
}

module "server" {
  source = "./modules/server"

  project_name     = "ivolve"
  vpc_id           = module.network.vpc_id
  public_subnet_id = module.network.public_subnet_ids[0]
  key_name         = "ivolve-jenkins-key"
  instance_type    = "t3.micro"
}
