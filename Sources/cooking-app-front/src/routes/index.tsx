import { createFileRoute } from "@tanstack/react-router"

const Index = () => {
  return (
    <div className="min-h-screen flex flex-col">
      <main className="flex-1 container mx-auto px-4 py-12">
        <div className="max-w-3xl mx-auto text-center space-y-6">
          <h2 className="text-4xl font-bold text-foreground">
            Welcome to the cooking app!
          </h2>
          <p className="text-lg text-muted-foreground">
            This is the home page. Start exploring recipes and enjoy cooking!
          </p>
        </div>
      </main>
    </div>
  )
}

export const Route = createFileRoute("/")({
  component: Index,
})

export default Index
