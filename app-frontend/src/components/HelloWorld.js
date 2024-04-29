import React, { useEffect, useState } from "react";

function HelloWorld() {
  const [greeting, setGreeting] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchHello = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/tasks/v1/helloWorld");

        if (!response.ok) {
          throw new Error(`Error fetching: ${response.status}`);
        }

        const data = await response.json();
        setGreeting(data.message || "Hello World!");
      } catch (error) {
        setError(error.message);
      }
    };

    fetchHello();
  }, []);
  if (error) {
    return <p>Error fetching greeting: {error}</p>;
  } else if (greeting) {
    return <p>{greeting}</p>;
  } else {
    return <p>Loading...</p>;
  }
}

export default HelloWorld;