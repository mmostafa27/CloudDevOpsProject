variable "project_name" {
  description = "Project name prefix"
  type        = string
  default     = "ivolve"
}

variable "vpc_id" {
  description = "VPC ID where the EC2 instance will be launched"
  type        = string
}

variable "public_subnet_id" {
  description = "Public subnet ID for the Jenkins EC2 instance"
  type        = string
}

variable "instance_type" {
  description = "EC2 instance type"
  type        = string
  default     = "t2.medium"
}

variable "key_name" {
  description = "EC2 Key Pair name for SSH access"
  type        = string
}
