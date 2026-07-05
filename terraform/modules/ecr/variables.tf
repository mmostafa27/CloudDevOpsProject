variable "project_name" {
  description = "Project name prefix"
  type        = string
  default     = "ivolve"
}

variable "repository_name" {
  description = "Name of the ECR repository"
  type        = string
  default     = "ivolve-app"
}
